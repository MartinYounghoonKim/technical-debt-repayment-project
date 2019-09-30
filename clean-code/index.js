// you can write to stderr for debugging purposes, e.g.
// process.stderr.write('this is a debug message');

function solution(A, K) {
  let result = "";
  const CORNER = "+";
  const HORIZONTAL = "|";
  const VERTICAL = "-";
  let maximumTextSize = 1;
  let arr = [];

  for (let i = 0; i < A.length; i++) {
    // 제일 긴 텍스트의 길이를 구한다.
    const numberLength = A[i].toString().length;
    if (maximumTextSize < numberLength) {
      maximumTextSize = numberLength;
    }
  }
  for (let i = 0; i < A.length; i++) {
    // 다중 배열로 만든다.
    arr[i] = [ ...A.splice(0, K) ];
    if (A.length > 0) {
      arr[i + 1] = [ ...A ];
    }
  }
  for (let i = 0; i < arr.length; i++) {
    drawLine(arr[i].length);
    console.log(arr[i]);
  }

  function drawLine (length) {
    result += CORNER;
    console.log(length);
    for (let i = 0; i < maximumTextSize; i++) {
      result += VERTICAL;
    }
  }
  console.log(result);
}
// console.log(
//   "+-----+-----+-----+-----+\n" +
//   "|    4|   35|   80|  123|\n" +
//   "+-----+-----+-----+-----+\n" +
//   "|12345|   44|    8|    5|\n" +
//   "+-----+-----+-----+-----+\n" +
//   "|   24|    3|   22|   35|\n" +
//   "+-----+-----+-----+-----+"
// )

solution([4, 35, 80, 123, 12345, 44, 8, 5], 10);
solution([4, 35, 80, 123, 12345, 44, 8, 5, 24, 3], 4);
solution([4, 35, 80, 123,12345,44,8,5, 24, 3, 22, 35], 4);
