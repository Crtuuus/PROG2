class Meritev():
    def __init__(self, vrednost, napaka = 0):
        self.vrednost = vrednost
        self.napaka = napaka
    def __str__(self):
        # Če imamo napako ≠ 0, dodamo ±napaka, sicer samo vrednost
        if self.napaka != 0:
            return f"{self.vrednost}±{self.napaka}"
        else:
            return f"{self.vrednost}"
    def __add__(self, other):
        return Meritev(self.vrednost+other.vrednost, self.napaka + other.napaka)
    def __sub__(self, other):
        return Meritev(self.vrednost-other.vrednost, self.napaka + other.napaka)

a = Meritev(1.5)
b = Meritev(0.5, 0.01)
c = Meritev(-1.5, 0.1)
print("a =", a)
print("c =", c)
print("a+b =", a + b)
print("a-b+c =", a - b + c)