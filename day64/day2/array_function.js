const numbers = [1, 2, 3, 4, 5];
console.log(numbers);

// map：把每個元素轉換成新值 (數值乘以2)
const doubled = numbers.map(n => n * 2);
console.log(doubled);

// filter：篩選出符合條件的元素 (保留偶數)
const evens = numbers.filter(n => n % 2 === 0);
console.log(evens);

// reduce：把所有元素累積成一個值（acc 是累計值，0 是初始值）
const sum = numbers.reduce((acc, n) => acc + n, 0);
console.log(sum);

// 串接使用 (先保留基數再乘以10)
const result = numbers
    .filter(n => n % 2 === 1)
    .map(n => n * 10);
console.log(result);