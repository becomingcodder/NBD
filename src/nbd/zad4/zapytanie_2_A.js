printjson(db.people.aggregate([
    { $unwind : "$credit" },
    { $group :
            {
                _id: "$credit.currency",
                "Total": {$sum: { $toDouble: "$credit.balance"}}
            }
    }, {$sort:{_id: 1}}
]).toArray());