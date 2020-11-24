db.people.find().forEach( function (x) {
    x.height = parseInt(x.height);
    x.weight = parseInt(x.weight)
    db.people.save(x);
});