import random
sez = [0]*8
stevila = random.sample(range(0,10**12), 10**6)
for i in stevila:
    if i%2 == 0 and i > sez[7]:
        pos = 7
        while pos >= 0 and i > sez[pos]:
            pos -= 1
        sez.insert(pos+1, i)
        if len(sez) > 8:
            sez.pop()
print(sez)
