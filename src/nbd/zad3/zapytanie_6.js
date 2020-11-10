db.people.insertOne({
    "sex" : "Male",
    "first_name" : "Aleksander",
    "last_name" : "Posmyk",
    "job" : "Software Engineer",
    "email" : "s8901@pjwstk.edu.pl",
    "location" : {
        "city" : "Warsaw",
        "address" : {
            "streetname" : "Koszykowa",
            "streetnumber" : "44"
        }
    },
    "description" : "non velit nec nisi vulputate nonummy maecenas tincidunt lacus at velit",
    "height" : "187.89",
    "weight" : "85.8",
    "birth_date" : "1990-09-05T11:51:38Z",
    "nationality" : "Poland",
    "credit" : [
        {
            "type" : "visa",
            "number" : "3581609550731672",
            "currency" : "PLN",
            "balance" : "1337.00"
        }
    ]
} );
printjson(db.people.findOne( { last_name: "Posmyk" } ));