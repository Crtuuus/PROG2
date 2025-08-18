def primes(n):
    sez = []
    p = 2
    while n != 1:
        if n%p==0:
            sez.append(p)
            n = n/p
        else:
            p += 1
    return sez

print(primes(96))
print(primes(12345))
print(primes(27644437))