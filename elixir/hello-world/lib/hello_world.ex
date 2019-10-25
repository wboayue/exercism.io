defmodule HelloWorld do
  @doc """
  Simply returns "Hello, World!"
  """
  @spec hello :: String.t()
  def hello(name \\ "World") do
    "Hello, #{name}!"
  end
end
