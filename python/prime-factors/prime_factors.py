def prime_factors(number):
    if number < 2:
        return []

    factor, factors = 2, []

    while number > 1:
        quotient, remainder = divmod(number, factor)

        if remainder == 0:
            factors.append(factor)
            number = quotient
        else:
            factor += 1

    return factors
