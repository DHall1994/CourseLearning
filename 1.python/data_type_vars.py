# vars - a reference (a name), reference a selection of memory( new location)
# protected location.

#x = 20
#person_one_age = 20
#personAge = 20

# consistency is key
# pep-8 style guide.

# naming convention: should be descriptive, can't start with a number, not capitalised, avoid key words.

# 1age = not allowed!
# Age = 10 reserved for class names
# AGE = constants - just convention.
# class = 10 avoid keywords.

#PascalCase - class names/file names
#camelCase - vars/functions/methods
#snake_case - vars/functions/methods

#a = 100
#b = 100

#print(a is b)

#def t1():
#    c = int(str(200))
#    return c
#def t2():
#    d = int(str(200))
#    return d

#print (t1() is t2())

# scope

#global_variable = "accessible everywhere"
#x = 20

#def my_function():
    #global x
    #x = 10 #shadowing
#    local_variable = "only accessible in this function"
#    print(global_variable)
#    print(local_variable)

#my_function()

#print(x)

# data types

#int = 20
#strings = "Hello"
#float = 12.23
#boolean = True/False, 1/0, something/nothing

# in built functions
# print()
# input()
# type()

#with open("output.txt", "w") as file:
    #sys.stdout = file
    #print("go to the file instead please!")
    
#sys.stdout = sys.__stdout__

#print("Hello")

# escape characters

# \ take the next symbol as its literal meaning
# \t tab, \n new line, \u unicode, \U unicode, \\ backslash, "hello \"David\""

#print("Person1: \"Hey how are you\nPerson2: I'm good thanks \U0001F604\"")

# string concatenation

#name = input("enter your name: ") # default to a string
#age = int(input("enter your age: ")) # convert to an int

#message = "your name is {}, your age is {}".format(name,age) # string formatting
#print(message)

#print("your name is " + name) #limited to same data type
#print("your name is", name, "your age is", age)
#print(f"your name is {name} your age is {age}") # f-string

# BODMAS
#floor division // - 10//3 = 3
#% 10%3 = 1 # gives the remainder

# string meothods

#print("hello world".upper())
#print("HELLO WORLD".lower())

#print("hello world".count("o"))

#print("hello world world world".replace("world", "class",2))

#print("hello,world".split(","))