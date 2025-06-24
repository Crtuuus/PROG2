#Fibo rekurzija
memo = [0]*101
memo[0] = 0
memo[1] = 1
for n in range(2, 101):
    memo[n] = memo[n-1] + memo[n-2]
print(memo)