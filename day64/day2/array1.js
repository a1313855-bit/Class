let number = [1, 2, 3, 4, 5];
for (let i = 0; i < number.length; i++) {
    console.log(number[i]);
}

let students = [
    { name: "Mr.A", score: 60 },
    { name: "Mr.B", score: 70 },
    { name: "Mr.C", score: 80 }
];

students.forEach(function (student, index) {
    console.log("index:" + index + " " + student.name + " " + student.score)
})