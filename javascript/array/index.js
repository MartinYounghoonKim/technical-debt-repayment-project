/// ---------------
(function () {
  const array = [1,2,3,4,5,6];
  const index = array.findIndex((current ) => current > 3);
})();

/// ---------------

(function () {
  const array = [10, 20, 30, 40, 50];
  const existed = array.includes(10);
  const notExisted = array.includes(60);
  console.log(existed);
  console.log(notExisted);
})();

/// ---------------

(function () {
  const array = [10, 20, 30, 40, 50];
  array.filter(function () {
  })
})();

/// ---------------
(function () {
  const array = [10, 20, 30, 40, 50];
  array.every(function (value, index, array) {
    return typeof value === "number";
  })
})();

/// ---------------
(function () {
  const array = [10, 20, 30, 40, 50];
  array.some(function (value, index, array) {
    return typeof value === "number";
  })
})();
