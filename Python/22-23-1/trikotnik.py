import random
import matplotlib.pyplot as plt

def Serpentinski(A, B, C, P1, number_of_points, counter=0):
    x, y = P1
    for _ in range(number_of_points):
        P2 = random.choice((A, B, C))
        x = (x + P2[0]) / 2
        y = (y + P2[1]) / 2
        plt.plot(x, y, marker="o", markersize=0.5, linestyle="None", color = "blue")

A = (0, 0)
B = (1, 0)
C = (0.5, 1)
n = 100000

plt.figure(figsize=(20, 20))
plt.axis("equal"); plt.axis("off")
Serpentinski(A, B, C, A, n)
plt.savefig("serpentinski.pdf")
