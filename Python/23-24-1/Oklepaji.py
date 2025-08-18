def is_valid(str):
    niz = ""
    for znak in str:
        if znak in ("{[("):
            niz = niz + znak
        if znak in ("}])"):
            if (niz[-1]+znak in ("()", "[]", "{}")):
                niz = niz[:-1]
            else:
                return False
    return True


for str in ["([{a}])", "([a]{b})", "{a}[ ](b)", "([a)", "([a)]", "({}[])()", "({a][b)c}"]:
    print(is_valid(str)) # True, True, True, False, False, True, False