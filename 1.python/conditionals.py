# if's elifs, elses
# allows for different pathways for our code to take. 


#is_Admin = True
#is_verified = False
#on_holiday = False

#if (is_Admin or is_verified) and not on_holiday:
#    print("ACESSS GRANTED")
#else:
#    print("DENIED!!")


#temp = 28

#if temp >= 30:
#    print("very hot")
#elif temp >= 20:
#    print("its warm")
#elif temp >= 10:
#    print("its ok")
#elif temp == 0:
#    print("its freezing")
#else:
#    print("generally bad")

# Excercise
# user to input a mark/grade
# mark over 80 print distinction
# mark over 60 print pass
# else fail.

#grade = int(input('Enter Grade: '))

#if grade > 80:
#    print("Distinction")
#elif grade > 60:
#    print("Pass")
#else:
#    print("Fail")

# multiple comparators

#deposit = 999
#password = "password1"

#if 0 < deposit < 100 and password == "password":
 #   print(f"thankyou for deposit of {deposit}")
#else:
#    print("failed to deposit")

# not

#if not 0 < deposit < 100 and password != "password":
#    print("failed to depsit")
#else:
#    print("thanks")

# in and not in

#name = "root123"

#if name in ("root", "admin","user"):
 #   print("invalid username")
#else:
#    print("accepted")

#if name not in ("root", "admin","user"):
#    print("accepted")
#else:
#    print("invalid username")

# exercise:
#weight converter app
#user to input weight
#input for kgs or lbs
#if statements to check the unit
#convert the value
#print out result

#optional - error handling for upper/lower case + incorrrect unit input.

#optional x2- error handling for numeric input (weight). 

#unit = input("Enter unit (kgs/lbs): ").lower()
#weight = input("Enter weight: ")
#if unit and weight.isnumeric():
#    weight = float(weight)
#    if unit == "kgs":
#        converted = weight * 2.20462
#        print(f"Weight in lbs: {converted}")
#    elif unit == "lbs":
#        converted = weight / 2.20462
#        print(f"Weight in kgs: {converted}")
#    else:
#        print("Invalid unit")   
#else:
#    print("Invalid input")

# first solution
#weight = float(input("Enter weight: "))
#unit = input("Enter K(kgs) or L(lbs): ")

#if unit.upper() == "K":
#    converted = weight / 0.45
#    print(f"Weight in lbs: {converted}")
#elif unit.upper() == "L":
#    converted = weight * 0.45
#    print(f"Weight in kgs: {converted}")
#else:
#    print("Invalid unit")
    
# second solution
#import sys
#while True:
#    try:
#        weight = float(input("Enter weight: "))
#        break
#    except ValueError:
#        print("Invalid input, please enter a numeric value")
#        sys.exit()
       
#while True:
#    unit = input("Enter K(kgs) or L(lbs): ")
#    if unit.upper() == "K":
#        converted = weight / 0.45
#        print(f"Weight in lbs: {converted}")
#        break
#    elif unit.upper() == "L":
#        converted = weight * 0.45
#        print(f"Weight in kgs: {converted}")
#        break
#    else:
#        print("Invalid unit")
#        break
    
# task to find the larger number without use of if statements or built in functions
#num = 10
#num1 = 20

#larger_num = ((num + num1) + abs(num - num1)) // 2

#print(larger_num)
