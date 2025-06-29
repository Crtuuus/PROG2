def is_valid(str):
    sez = []
    for znak in str:
        if znak in("(","[","{"):
            sez.append(znak)
        if znak in(")","]","}"):
            sez[-1] = sez[-1] + znak
            if sez[-1] in ("()","[]",'{}'):
                sez.pop()
            else:
                return False
    return True

for str in ["([{a}])", "([a]{b})", "{a}[ ](b)", "([a)", "([a)]", "({}[])()", "({a][b)c}"]:
    print(is_valid(str)) # True, True, True, False, False, True, False
