//1.Retrieve all documents from the "products" collection where the ""price"" is greater than $50."
db.products.find({price:{$gt:50}})

//2.Use the aggregation framework to find the average ""rating"" 
//for all documents in the ""reviews"" collection grouped by the ""product_id."""

db.reviews.aggregate([
    {
        $lookup:{
            from:"products",
            localField:"_id",
            foreignField:"productId",
            as:"review"
            
        }
    },
    {
        $group:{_id:"$productId","Average":{$avg:"$rating"}}
    }

])
// 3.Count the number of documents in the ""orders"" collection 
// for each unique value in the ""customer_id"" field. Display the results with the customer ID and the corresponding count."
db.orders.aggregate([
    {
        $group:{_id:"$costomerId","count":{$sum:1}}
    }
])

// 4.Project only the ""name"" and ""totalSales"" fields from the ""customers"" collection. Calculate the total sales (totalSales) for each customer, summing up the 
// values in the ""purchases"" array. Sort the results in descending order based on the total sales."
db.customers.aggregate([
    {
      $lookup:{
        from:"orders",
        localField:"purchase",
        foreignField:"product_id",
        as:"purchase"
    }
    },
    {
        $unwind:"$purchase"
    },{
        $group:{_id:"$name",totalSales:{$sum:"$purchase.quantity"}}
    },
    {
        $project:{name:1,totalSales:1}
    },{
        $sort:{totalSales:-1}
    }
])

// 5.Find the average quantity of each item sold in the ""sales"" 
// collection. Consider using the $unwind stage to flatten the ""items"" array before calculating the average quantity"

db.orders.aggregate([
    
    {
        $group:{_id:"$productId",Average:{$avg:"$quantity"}}
     
    }

])





db.createCollection("reviews")
db.createCollection("costomers")

db.costomers.insertMany(
    [
    {name: "Amod",productId:[ObjectId('65b1e4d43452e43d18174e0d'),ObjectId('65b1e4d43452e43d18174e0e')]},
    {name: "Promod",productId:[ObjectId('65b1e4d43452e43d18174e0d'),ObjectId('65b1e4d43452e43d18174e0f')]},
    {name: "Vinod",productId:[ObjectId('65b1e4d43452e43d18174e0d'),ObjectId('65b1e4d43452e43d18174e0d')]},
    {name: "Nitu",productId:[ObjectId('65b1e4d43452e43d18174e0d')]},
    {name: "Avinash",productId:[ObjectId('65b1e4d43452e43d18174e0d')]},
   
    ]
    )



db.reviews.insertMany(
    [
    {rating: 2,productId:ObjectId('65b1e4d43452e43d18174e0d'),costomerId:ObjectId('65bb34899a90e0debf98f5bd')},
    {rating: 4,productId:ObjectId('65b1e4d43452e43d18174e0f'),costomerId:ObjectId('65bb34899a90e0debf98f5be')},

    {rating: 4,productId:ObjectId('65b1e4d43452e43d18174e0e'),costomerId:ObjectId('65bb34899a90e0debf98f5c0')},
    ]
    )

    db.createCollection("orders")


    db.orders.updateMany(
        [
        {productId:ObjectId('65b1e4d43452e43d18174e0d'),costomerId:ObjectId('65bb34899a90e0debf98f5bd')},
        {productId:ObjectId('65b1e4d43452e43d18174e0f'),costomerId:ObjectId('65bb34899a90e0debf98f5be')},
        {productId:ObjectId('65b1e4d43452e43d18174e0e'),costomerId:ObjectId('65bb34899a90e0debf98f5c0')},
       
        ]
        )

        db.orders.updateMany({},{$set:{quantity:10}})
        db.orders.updateOne({_id:ObjectId('65bb35e19a90e0debf98f5c5')},{$set:{quantity:14}})

        db.reviews.aggregate([
            {
                $lookup:{
                    from:"products",
                    localField:"_id",
                    foreignField:"productId",
                    as:"review"
                    
                }
            },
            {
                $group:{_id:"$productId","Average":{$avg:"$rating"}}
            }
        
        ])



        db.orders.aggregate([
    
            {
                $group:{_id:"$productId",Average:{$avg:"$quantity"}}
             
            }
        
        ])



db.customers.aggregate([
    {
      $lookup:{
        from:"orders",
        localField:"purchase",
        foreignField:"product_id",
        as:"purchase"
    }
    },
    {
        $unwind:"$purchase"
    },{
        $group:{_id:"$name",totalSales:{$sum:"$purchase.quantity"}}
    },
    {
        $project:{name:1,totalSales:1}
    },{
        $sort:{totalSales:-1}
    }
])