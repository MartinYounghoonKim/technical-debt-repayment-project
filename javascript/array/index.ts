interface Array<T> {
  filter<S extends T>(callbackfn: (value: T, index: number, array: T[]) => value is S, thisArg?: any): S[];
  filter(callbackfn: (value: T, index: number, array: T[]) => unknown, thisArg?: any): T[];
}

interface Parent {
  a: number;
}
interface Child extends Parent {
  b: number;
}

const arr: Parent[] = [];
const arr2: Child[] = arr.filter(function () {
  return false;
});
