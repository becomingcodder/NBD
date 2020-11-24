var m = function() {
    emit(this.job, null);
};
var r = function(k, v) {};
db.people.mapReduce(m,r, {out: "jobs"})
printjson(db.jobs.find({},{id:1}).toArray())