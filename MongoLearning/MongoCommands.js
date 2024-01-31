// •	Mongo DB is document base database. 
// •	MQI is called mongo query API also called MQL -mongo query language.
// •	Collection, Document, schema are like database, table, rules in SQL.

// Commands 
// 1.	mongosh – 

// creating a new db
// -use dbname
// --use bajaj-demo

// •	db is a pointer object of current database.
// •	db.createCollection(‘’user) -to create collection 
// •	to insert a document – db.collectionname.insert(document)
// •	to view data in mongo db -db.collectionname.find() 
// •	bulk insert -db.collectionName.insertMany([{},{},………])
// •	to view data from collection -db.collectionName.find()
// •	to view data from collection -db.collectionName.find({},{},…….)
// •	to find data from collection with condition db.users.find({city:"Pune"},{name:1,city:1}) – 1 is tue 0 is false
// •	to delete  document- db.collectionName.deleteOne({prop:value,….})
// •	to delete multiple document- db.collectionName.deleteMany({prop:value,…..})
// •	to drop collection -db.collectionName.drop()-
// •	to show collection – show collection.



db.products.insertMany([

    {name:"Samsung M51",price:34000,quantity:120,category:["Mobiles","Electronics"]},
    {name:"Water Bottle",price:70,quantity:350,category:["Home","Appliance"]},
    {name:"Plate",price:100,quantity:500,category:["Culinary","Home"]},
    {name:"Iphone Charger",price:2000,quantity:120,category:["Mobiles","Electronics"]},
    
    
])

db.products.updateMany({},{$set:{mainCategory:"Mobile",vendor:"Vinayak"}})

// to update or add a new property in existing doc 
// db.collectioName.updateOne({prop:val},{$set:{prop:newval,...}})
// db.collectioName.updateMany({prop:val},{$set:{prop:newval,...}})
// db.collectionName.updateMany({},{$set:{prop:newval,....}})

db.products.updateOne({_id:ObjectId('65b1e3ea46044a9ddd9d114b')},{$set:{mainCategory:"Culinary",vendor:"Sampada"}})

// to increment or decrement 

db.collectionName.updateOne({},{$set:{prop:{$inc:val}}})

// Query opeartors 

//comparison op

db.products.find({quantity:{$eq:120}})

db.products.find({quantity:{$ne:120}})


db.products.find({category:"Mobiles"})

db.products.find({price:{$lt:1000}})

db.products.find({price:{$gt:1000}})

db.products.find({quantity:{$gte:350}})

db.products.find({vendor:{$in:["Vinayak","Akash"]}})

db.products.find({vendor:{$nin:["Vinayak","Akash"]}})

db.products.find().count()

db.products.find().limit(2)

db.products.find().skip(2)

db.products.find().sort({property:[1,-1]})

// logical op 


db.products.find({price:{$lt:1000},quantity:{$gt:100}})

db.products.find({$and:[{price:{$lt:1000}},{quantity:{$gt:100}}]})

db.products.find({$or:[{price:{$lt:1000}},{quantity:{$gt:120}}]})





db.createCollection('users',{
    validator:{
        $jsonSchema:{
            bsonType:"object",
            required:["name","age","city","hobbies","email","gender"],
            properties:{

                name:{
                    bsonType:"string",
                    description:"Name Field",
                    maxLength:20
                },
                age:{
                    bsonType:"int",
                    description:"Age Field",
                    minimum:12,
                    maximum:100
                },
                city:{
                    bsonType:"string"
                },
                hobbies:{
                    bsonType:"array",
                    minItems:1,
                    maxItems:4,
                    items:{
                        bsonType:"string"
                    }
                },
                email:{
                    bsonType:"string",
                    pattern:"[a-z0-9._%+\-]+@[a-z0-9.\-]+\.[a-z]{2,}$",
                    unique:true
                },
                gender:{
                    bsonType:"string",
                    enum:["Male","Female","Other"]
                }


            }
        }
    }
});


// Agregation 

// $match 
// $group  [$max,$min,$sum,$avg,$push]
// $limit 
// $sort 
// $project
// $filter 
// $unwind
// $lookup 
// $out 

// select city from users 
// group by city 


// normal grouping 
db.users.aggregate([
    
    {
     $group:{_id:"$city","count":{$sum:1}}
    }
 ])

// pushing a single prop 
db.users.aggregate([
    
   {
    $group:{_id:"$city","count":{$sum:1},"names":{$push:"$name"}}
   }
])

// push multiple props 

db.users.aggregate([
    
    {
     $group:{_id:"$city","count":{$sum:1},"people":{$push:{name:"$name",age:"$age"}}}
    }
 ])


//  push the whole doc 


db.users.aggregate([
    
    {
     $group:{_id:"$city","count":{$sum:1},"people":{$push:"$$ROOT"}}
    },

 ])


//  direct sorting

 db.users.aggregate([
    {
        $group:{_id:"$city","count":{$sum:1},"names":{$push:"$name"}}
    },
    {
        $sort:{count:1}
    },
    {
        $project:{count:0}
    }
 ])


 db.users.aggregate([

    {
        $match:{city:"San Francisco"}
    },
    
    {
        $out:"agg_data_sf"
    }

 ])



//  { $filter: { input: <array>, as: <string>, cond: <expression> } }



db.employees.aggregate([
    {
        $lookup:{
            from:"departments",
            localField:"department_id",
            foreignField:"_id",
            as:"department"
        }
    },
    {
        $unwind:"$department"
    }
])


db.departments.aggregate([
    {
        $lookup:{
            from:"employees",
            localField:"_id",
            foreignField:"department_id",
            as:"employees"
        }
    },
    {
        $match:{employees:{$gt:{$size:0}}}
    }
])



db.departments.aggregate([
    {
        $lookup:{
            from:"employees",
            localField:"employees",
            foreignField:"_id",
            as:"employees"
        }
    },
    {
        $unwind:"$employees"
    }
])



db.employees.aggregate([
    {
        $lookup:{
            from:"departments",
            localField:"_id",
            foreignField:"employees",
            as:"department"
        }
    }
])



// Agregation 

// $match 
// $group  [$max,$min,$sum,$avg,$push]
// $limit 
// $sort 
// $project
// $filter 
// $unwind
// $lookup 
// $out 


///

db.users.find({gender:"Male"})

db.users.aggregate([
    {
        $match:{gender:"Male",city:"San Francisco"}
    }
   
])


db.users.aggregate([
   
    {
        $group:{_id:null,"count":{$avg:'$age'}}
    }
   
])


db.users.aggregate([
   
    {
        $group:{_id:'$city',"count":{$sum:1},"people":{$push:"$name"}}
    },
    {
        $project:{count:0}
    },
    {
        $sort:{count:1}
    },
   
    


   
])




// select sum(),city from users 
// group by city

// to create index 

db.collectionName.createIndex({prop:[1,-1]})

db.collectionName.createIndexes([{prop:[1,-1]}...])

// to create a compound index 

db.collectionName.createIndex({prop1:[1,-1],prop2:[1,-1]})

// to view indexes 

db.collectionName.getIndexes()

// to drop index 

db.collectionName.dropIndex("index_name")


// to view stats of queries 


db.collectionName.anyOperation().explain()


db.users.updateOne({name:"Saurabh"},{$set:{age:28,city:"Mumbai",gender:"Male",email:"saurabh@gmail.com",hobbies:["Cricket"]}},{upsert:true})


//////////
db.products.insertMany(
    [
    {name: "Samsung M51",price:34000,quantity:120,category:["Mobile","Electronics"]},
    {name: "Water Bottle",price:70,quantity:350,category:["Home","Appliance"]},
    {name: "Plate",price:100,quantity:500,category:["Culinary","Appliance"]}
    
    ]
    )

    db.products.updateOne({_id: ObjectId('65b1e4d43452e43d18174e0f')},{$set:{
        name:"Samsung M52"
    }})

db.products.updateMany({},{$set:{mainCategory:"Mobile",vender:"vinayak"}})

db.products.find({price:{$lt:1000},quantity:{$gt:100}})

db.products.find({$and:[{price:{$lt:1000}},{quantity:{$gt:100}}]})



db.user.insertMany(
    [
    {name: "Amod",age:27,city:"Pume",hobbies:["Singing","Reading"],email:"amod@gmail.com",gender:"Male"},
    {name: "Promod",age:22,city:"Mumbai",hobbies:["Singing","Dancing"],email:"pramod@gmail.com",gender:"Male"},
    {name: "Vinod",age:23,city:"Nasik",hobbies:["Playing","Reading"],email:"viod@gmail.com",gender:"Male"},
    {name: "Sampda",age:24,city:"Patna",hobbies:["Singing","Reading"],email:"sampda@gmail.com",gender:"Female"},
    {name: "Arun",age:25,city:"Samastipur",hobbies:["Runing","Reading"],email:"arun@gmail.com",gender:"Male"}
    ]
    )

    db.user.find({hobbies:"Playing"})

    db.user.find({$and:[{city:"Nasik"},{age:{$gt:22}}]})

    db.user.find({gender:"Male"},{name:1})

    db.user.find({city:"Pune"},{name:1,hobbies:1})
   
   
    db.user.find({city:{$nin:["Nasik","Patna"]}}, {name:1,city:1})


    db.users.insertOne({name: "Amod",age:27,city:"Pune",hobbies:["Singing","Reading"],email:"amod@gmail.com",gender:"Male"})

    db.createCollection('users',{
        validator:{
            $jsonSchema:{
                bsonType:"object",
                required:["name","age","city","hobbies","email","gender"],
                properties:{
                    name:{
                        bsonType:"string",
                        description:"Name Field"
                    },
                    age:{
                        bsonType:"int",
                        description:"Age Field",
                        minimum :12,
                        maximum:100
                    },
                    city:{
                        bsonType:"string",
                        description:"City Field",
                    },
                    hobbies:{
                        bsonType:"array",
                        description:"hobbies Field",
                        minItems:1,
                        maxItems:4,
                        items:{
                            bsonType:"string"
                        }
                    },
                    email:{
                        bsonType:"string",
                        description:"Email Field",
                        pattern:"^([a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$)",
                    
                     },
                    gender:{
                        bsonType:"string",
                        description:"Gender Field",
                        enum:["Male","Female","Other"]
                    }
                }
            }
        }
    })

db.user.find().sort({name:1})// 1 and -1 for asccending and desccending 

db.users.find().limit(2).skip(2)

//  -------------------------------------------

// Aggregation - main working of aggregation is grouping 
// Operators

// $match
// $group  [$max,$min,$sum,$avg,$push]
// $linit
// $sort
// $filter
// $unbind
// $lookup


db.user.insertMany(
    [
        {name: "Thor",age:45,city:"Asguard",hobbies:["flying","Fighting"],email:"thor@gmail.com",gender:"Male"},
        {name: "Ironman",age:32,city:"New york",hobbies:["Defending","Philanthropy"],email:"ironman@gmail.com",gender:"Male"},
        {name: "Jane foster",age:32,city:"Mumbai",hobbies:["Astronomy","Singing"],email:"jane@gmail.com",gender:"Female"},
        {name: "Casey",age:27,city:"Mumbai",hobbies:["Intern","Singing"],email:"casey@gmail.com",gender:"Female"},
        {name: "Loki",age:45,city:"Asguard",hobbies:["flying","Fighting"],email:"loki@gmail.com",gender:"Male"},
    ]
    )

    //Syntex
   // db.collectionName.aggregate([],{})
    //first parameter is array

    db.users.aggregate([
        {$match:{"name":"Thor"}}
    ])

    db.users.aggregate([
        {$match:{$or:[{city:"Mumbai"},{age:27}]}}
    ])
    //same 
    db.users.find({$or:[{city:"Mumbai"},{age:27}]})

    db.users.aggregate([
        {$group:{_id:"$city"}}
    ])

    // it working like count in sql
    db.users.aggregate([
        {$group:{_id:"$city","noofpeople":{$sum:1}}}
    ])
    
     //sum of age by 
    db.users.aggregate([
        {$group:{_id:"$city","noofpeople":{$sum:"$age"}}}
    ])

    db.users.aggregate([
        {$match:{age:{$lt:30}}},
        {$group:{_id:"$city","noofpeople":{$sum:1}}}
    ])


    //push is use to add in array single property
    db.users.aggregate([
        {$group:{_id:"$city","count":{$sum:1},"Names":{$push:"$name"}}}
    ])

    db.users.aggregate([
        {$group:{_id:"$city","count":{$sum:1},"People":{$push:{
            "Name":"$name","Age":"$age"
        }}}}
    ])


    //push the whole document
    db.users.aggregate([
        {$group:{_id:"$city","count":{$sum:1},"People":{$push:"$$ROOT"}}}
    ])

    db.users.aggregate([
        {
            $group:{_id:"$city","count":{$sum:1},"Name":{$push:"$name"}}
        },
        {
            $sort:{count:1}
        },
       { $project:{count:0}}
    ])


    db.users.aggregate([
        {
            $match:{city:"San Francisco"}
        },
        {
            $unwind:"$hobbies"
        },
        { 
            $limit:5
        }
        
    ])


    db.users.aggregate([
        {
            $match:{city:"San Francisco"}
        },

        { 
            $limit:5
        },
        {
            $out:"agg_names"
        }
    ])

    db.users.find({city:"San Francisco"}).aaggregate([{$unwind:"$hobbies"}])



    // relation in mongodb 30 jan 2024
    db.employees.aggregate([
        {
            $lookup:{
                from:"departments",
                localField:"department_id",
                foreignField:"_id",
                as:"department"
            }
        }
    ])



    db.employees.aggregate([
        {
            $lookup:{
                from:"departments",
                localField:"department_id",
                foreignField:"_id",
                as:"department"
            }
        },{
            $unwind:"$department"
        }
    ])


    db.departments.aggregate([
        {
            $lookup:{
                from:"employees",
                localField:"_id",
                foreignField:"department_id",
                as:"employees"
            }
        },{
           $match:{employees:{$gt:{$size:0}}}
        }
    ])


    db.departments.aggregate([
        {
            $lookup:{
                from:"employees",
                localField:"employees",
                foreignField:"_id",
                as:"employees"
            }
        },{
           $match:{employees:{$gt:{$size:0}}}
        },
        {
            $unwind:"$employees"
        }
    ])


    // filter Aggregation
    db.users.aggregate([
        {
            $project:{
                hobbies:{
                    $filter:{
                        input:"$hobbies",
                        as:"hobby",
                        cond:{$eq:["$$hobby","Singing"]}
                    }
                }
            }
        }
    ])

    db.users.aggregate([

        {
            $group:{_id:"$city","count":{$sum:1}}
        }
    ])

    /// update value or object in array  inside the dicument
    db.collectionName.updateOne({},{$push:{arrayName: newValue}})


    db.users.updateOne({name:"John Doe"},{$push:{hobbies : "Painting"}})

    db.users.updateMany({},{$push:{hobbies : "Hunting"}})

    ///////////






db.Students.insertMany(
    [
    {name: "Amod",age:27,city:"Pune",hobbies:["Singing","Reading"],courseId:[ObjectId('65b9e574c85da59ee5f8248d'),ObjectId('65b9e574c85da59ee5f8248e')]},
    {name: "Promod",age:24,city:"Pune",hobbies:["Hunting","Reading"],courseId:[ObjectId('65b9e574c85da59ee5f8248e'),ObjectId('65b9e574c85da59ee5f8248f')]},
    {name: "Vinod",age:30,city:"Pune",hobbies:["Singing","Playing"],courseId:[ObjectId('65b9e574c85da59ee5f8248f'),ObjectId('65b9e574c85da59ee5f8248f')]},
    {name: "Nitu",age:32,city:"Nasik",hobbies:["Singing","Reading"],courseId:[ObjectId('65b9e574c85da59ee5f8248f')]},
    {name: "Avinash",age:25,city:"Mumbai",hobbies:["Singing","Reading"],courseId:[ObjectId('65b9e574c85da59ee5f8248d')]},
   
    ]
    )
    
    db.createCollection('Students',{
        validator:{
            $jsonSchema:{
                bsonType:"object",
                required:["name","city","hobbies","age","courseId"],
                properties:{
                    name:{
                        bsonType:"string",
                        description:"Name Field"
                    },
                    city:{
                        bsonType:"string",
                        description:"City Field",
                    },
                    hobbies:{
                        bsonType:"array",
                        description:"hobbies Field",
                        minItems:1,
                        maxItems:4,
                        items:{
                            bsonType:"string"
                        }
                    },
                    age:{
                        bsonType:"int",
                        description:"Age Field",
                        minimum :12,
                        maximum:100
                    },
                    courseId:{
                        bsonType:"array",
                        description:"course Id",
                        items:{
                            bsonType:"objectId"
                        }
                     }
                }
            }
        }
    })




    db.courses.insertMany(
        [
            {name:"Math",fees:34000,duration:10},
            {name:"Science",fees:34000,duration:5},
            {name:"English",fees:34000,duration:6},
        ]
        )

    db.createCollection('courses',{
        validator:{
            $jsonSchema:{
                bsonType:"object",
                required:["name","fees","duration"],
                properties:{
                    name:{
                        bsonType:"string",
                        description:"Name Field"
                    },
                    fees:{
                        bsonType:"int",
                        description:"Age Field",
                        minimum :0,
                        maximum:100000
                    },
                    duration:{
                        bsonType:"int",
                        description:"duration",
                     }
                }
            }
        }
    })



    //1

    db.Students.aggregate([
        {
            $lookup:{
                from:"courses",
                localField:"courseId",
                foreignField:"_id",
                as:"courses"
                
            }
        }
    ])
         //2
         db.Students.find({hobbies:"Playing"},{courseId:0})



//3
    db.Students.aggregate([
    
        {
         $group:{_id:"$city","count":{$sum:1}}
        }
     ])


     //4
    db.courses.aggregate([
        {
            $lookup:{
                from:"Students",
                localField:"_id",
                foreignField:"courseId",
                as:"student"
                
            }
        },
        {
            $project:{
                "studentCount":{$size:"$student"},name:1
                
            }
        }
    
    ])


 