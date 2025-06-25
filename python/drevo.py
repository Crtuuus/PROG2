import math
import matplotlib.pyplot as plt


def plot_tree(x, y, alpha, d, h):
    # 1. nariši steblo od (x,y) do (x2,y2)
    x2 = x + d * math.cos(alpha)
    y2 = y + d * math.sin(alpha)
    plt.plot([x, x2], [y, y2], 'k-')
    # 2. če višina večja od 1, nariši levo in desno poddrevo
    if h > 1:
        plot_tree(x2, y2, alpha + math.pi/8, d * 3/4, h - 1)
        plot_tree(x2, y2, alpha - math.pi/8, d * 3/4, h - 1)

plt.figure()
plot_tree(0, 0, math.pi/2, 1, 10)
plt.gca().set_aspect('equal')
plt.axis('off')
plt.savefig('fractals.pdf')
