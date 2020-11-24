var map = function() {
    emit(this.sex, { sumH:this.height, sumW:this.weight,count:1});
};
var reduce = function(k, val) {
    reducedVal = { sumH: 0, sumW: 0 , count:0};
    for (var i = 0; i < val.length; i++) {
        reducedVal.sumH +=val[i].sumH;
        reducedVal.sumW+= val[i].sumW;
        reducedVal.count +=val[i].count; }

    return reducedVal;
};
function finalize(key, v) {
    return {
        avgHeight: v.sumH/ v.count,
        avgWeight: v.sumW/ v.count
    };
}
var params = {out: "height_and_weight_AVG", finalize : finalize };
db.people.mapReduce(map,reduce,params)
printjson(db.height_and_weight_AVG.find({}).toArray())