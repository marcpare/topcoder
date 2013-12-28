var X = ['X', 'M', 'J', 'Y', 'A', 'U', 'Z'];
var Y = ['M', 'Z', 'J', 'A', 'W', 'X', 'U'];
// LCS len 4

var M = X.length;
var N = Y.length;

/*
function memoizer (f) {
  var memo = {};
  var recur = function (i, j) {
    var result = memo[[i, j]];
    if (typeof result !== 'number') {
      result = f(recur, i, j);
      memo[[i, j]] = result;
    }
    return result;
  }
  return recur;
}

var LCS = memoizer(function (recur, i, j) {
  if (i == 0 || j == 0) return 0;
  return (X[i] == Y[j]) ?
    recur(i-1, j-1) + 1 :
    Math.max(recur(i, j-1), recur(i-1, j));
});
*/


function memoized (f) {
  var memo = {};
  return function (i, j) {
    var args = [].slice.call(arguments); // otherwise doesn't work as a key, see below
    var res = memo[args];
    if (typeof memo[args] === 'undefined') {
      res = f(i, j);
      memo[args] = res;
    }
    return res;
  }
}

var LCS = memoized(function (i, j) {
  if (i == 0 || j == 0) return 0;
  return (X[i] == Y[j]) ?
    LCS(i-1, j-1) + 1 :
    Math.max(LCS(i, j-1), LCS(i-1, j));
});


console.log(LCS(M, N));

bar = {};
function foo () {
  console.log(arguments);
  bar[arguments] = arguments;
}
foo(1, 2);
foo(2, 1); // overwrites
foo(2, 2); // overwrites
console.log(bar);

// interesting!! arguments is converted to a string: '[object Arguments]'