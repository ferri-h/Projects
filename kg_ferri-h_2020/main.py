letters = []

check = False
# Gets strings from stdin
s1 = input("Enter First String: ")
s2 = input("Enter Second String: ")

# Stores letters in list and ignores repeated letters
for i in range(len(s1)):
    if s1[i] not in letters:
        letters.append(s1[i])

# there cannot be less x's then y's because all in x will not be mapped, ex 'foo' and 'bar' is false
if len(letters) < len(s2):
    check = False

# True, because at this point we have ignored repeated letters in line 9
if len(letters) >= len(s2):
    check = True

#print(letters)   
print(check)    

