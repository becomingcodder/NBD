var m = function() {
    for(var i=0;i<this.credit.length;i++)
        emit(this.credit[i].currency, parseInt(this.credit[i].balance));
};
var r = function(k, val) {
    return Array.sum(val);
};
db.people.mapReduce(m,r,{out: "total"})
printjson(db.total.find({}).toArray())