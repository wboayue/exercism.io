# Sublist

Write a function to determine if a list is a sublist of another list.

Write a function that given two lists determines if the first list is
contained within the second list, if the second list is contained within
the first list, if both lists are contained within each other or if none
of these are true.

Specifically, a list A is a sublist of list B if by dropping 0 or more elements
from the front of B and 0 or more elements from the back of B you get a list
that's completely equal to A.

Examples:

 * A = [1, 2, 3], B = [1, 2, 3, 4, 5], A is a sublist of B
 * A = [3, 4, 5], B = [1, 2, 3, 4, 5], A is a sublist of B
 * A = [3, 4], B = [1, 2, 3, 4, 5], A is a sublist of B
 * A = [1, 2, 3], B = [1, 2, 3], A is equal to B
 * A = [1, 2, 3, 4, 5], B = [2, 3, 4], A is a superlist of B
 * A = [1, 2, 4], B = [1, 2, 3, 4, 5], A is not a superlist of, sublist of or equal to B

## Running tests

Execute the tests with:

```bash
$ elixir bob_test.exs
```

(Replace `bob_test.exs` with the name of the test file.)


### Pending tests

In the test suites, all but the first test have been skipped.

Once you get a test passing, you can unskip the next one by
commenting out the relevant `@tag :pending` with a `#` symbol.

For example:

```elixir
# @tag :pending
test "shouting" do
  assert Bob.hey("WATCH OUT!") == "Whoa, chill out!"
end
```

Or, you can enable all the tests by commenting out the
`ExUnit.configure` line in the test suite.

```elixir
# ExUnit.configure exclude: :pending, trace: true
```

For more detailed information about the Elixir track, please
see the [help page](http://exercism.io/languages/elixir).


