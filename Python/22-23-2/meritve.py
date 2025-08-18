class Measurement:
    def __init__(self,value,error=0):
        self.value = float(value)
        self.error = float(error)
    def __str__(self):
        if self.error == 0:
            return str(self.value)
        else:
            return (f"{self.value} ± {self.error}")

    def __add__(self, other):
        return Measurement(self.value + other.value, self.error + other.error)
    
    def __sub__(self, other):
        return Measurement(self.value - other.value, self.error + other.error)

a = Measurement(1.5)
b = Measurement(0.5, 0.01)
c = Measurement(-1.5, 0.1)
print("a =", a)
print("c =", c)
print("a+b =", a + b)
print("a-b+c =", a - b + c)