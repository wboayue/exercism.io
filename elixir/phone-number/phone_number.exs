defmodule Phone do
  @doc """
  Remove formatting from a phone number.

  Returns "0000000000" if phone number is not valid
  (10 digits or "1" followed by 10 digits)

  ## Examples

  iex> Phone.number("123-456-7890")
  "1234567890"

  iex> Phone.number("+1 (303) 555-1212")
  "3035551212"

  iex> Phone.number("867.5309")
  "0000000000"
  """
  @spec number(String.t) :: String.t
  def number(raw) do
    raw
    |> strip_punctuation
    |> coerce_number
  end

  defp strip_punctuation(raw) do
    String.replace(raw, ~r/[^[:digit:][:alpha:]]+/, "")  
  end

  defp coerce_number(<< number::binary-size(10) >>), do: number
  defp coerce_number(<< "1", number::binary-size(10) >>), do: number
  defp coerce_number(_), do: "0000000000"

  @doc """
  Extract the area code from a phone number

  Returns the first three digits from a phone number,
  ignoring long distance indicator

  ## Examples

  iex> Phone.area_code("123-456-7890")
  "123"

  iex> Phone.area_code("+1 (303) 555-1212")
  "303"

  iex> Phone.area_code("867.5309")
  "000"
  """
  @spec area_code(String.t) :: String.t
  def area_code(raw) do
    raw
    |> number
    |> extract_area_code
  end

  defp extract_area_code(<< npa_code::binary-size(3) >> <> _), do: npa_code

  @doc """
  Pretty print a phone number

  Wraps the area code in parentheses and separates
  exchange and subscriber number with a dash.

  ## Examples

  iex> Phone.pretty("123-456-7890")
  "(123) 456-7890"

  iex> Phone.pretty("+1 (303) 555-1212")
  "(303) 555-1212"

  iex> Phone.pretty("867.5309")
  "(000) 000-0000"
  """
  @spec pretty(String.t) :: String.t
  def pretty(raw) do
    raw
    |> number
    |> format_number
  end

  defp format_number(<< npa_code::binary-size(3), co_code::binary-size(3), number::binary-size(4) >>) do
    format_number(npa_code, co_code, number)  
  end

  defp format_number(npa_code, co_code, number) do
    "(#{npa_code}) #{co_code}-#{number}" 
  end
end
