def determine_triangle(a, b, c):
   sides = sorted([a, b, c])
   if sides[2] >= sides[0] + sides[1]:
       return "Invalid"
   
   if a == b == c:
       return "Equilateral"
   elif a == b or b == c or a == c:
       return "Isosceles"
   else:
       return "Scalene"

while True:
   a, b, c = map(int, input().split())
   if a == b == c == 0:
       break
   print(determine_triangle(a, b, c))