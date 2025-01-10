# Chapter 04 Lab
# Squares
# num = 1

# while num <= 100:
#     square = num ** 2
#     print(f"Number: {num}, Square: {square}")
    
#     if square > 2000:
#         break
    
#     num += 1

# Factorial
# number = int(input("Enter an integer: "))

# factorial = 1
# current = 1

# while current <= number:
#     factorial *= current
#     current += 1

# print(f"The factorial of {number} is {factorial}")

# Investment
initial_investment = float(input("Enter the initial investment amount (£): "))
target_value = float(input("Enter the target value (£): "))
interest_rate = float(input("Enter the interest rate (as a percentage): ")) / 100  # Convert to a decimal

current_value = initial_investment
years = 0

while current_value < target_value:
    current_value += current_value * interest_rate  # Add yearly interest
    years += 1  # Increment the year counter

print(f"It will take {years} years for an investment of £{initial_investment} to grow to £{target_value} at an interest rate of {interest_rate * 100}%.")


# Chapter 05 Lab
# import statistics

# data = "100,30,53,67,85,87,50,45,51,72,64,69,59,17,22,23,44,25,16,67,85,87,50,45,51,72,59,14,50,55,32,23,24,25,37,28,39,30,33,35,40,34,41,43,94,95,59,98,99,44,45,47,48,49,53,61,63,69,75,77,60,83"
# grades = data.split(",")
# grades = list(map(int, grades))

# min_value = min(grades)
# max_value = max(grades)
# average = round(sum(grades) / len(grades), 2)
# mean_value = round(statistics.mean(grades), 2)
# median_value = statistics.median(grades)

# print("Minimum: {}, Maximum: {}, Average: {}, Mean: {}, Median: {}".format(min_value, max_value, average, mean_value, median_value))
