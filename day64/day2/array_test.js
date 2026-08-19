a1 = [1, 2, 3, 4, 5];
b1 = [a1[0], a1[1], a1[2], a1[3], a1[4]]
b1.forEach(function (value, index) {
    b1[index] = value * 2;
});
console.log(a1);
console.log(b1);