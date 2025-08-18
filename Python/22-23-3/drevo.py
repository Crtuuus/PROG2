import math
import matplotlib.pyplot as plt
def plot_tree(x, y, alpha, d, h):
    # 1. nariši steblo drevesa
    x2, y2 = x + d*math.cos(alpha), y +d*math.sin(alpha)
    plt.plot([x, x2],[y, y2], linewidth=0.8)
    # 2. rekurzivno nariši poddrevesi
    if h > 1:
        plot_tree(x2,y2, alpha + math.pi/8, 3/4*d, h-1)
        plot_tree(x2,y2, alpha - math.pi/8, 3/4*d, h-1)
    pass
plt.figure(figsize=(6,6))
plot_tree(0, 0, math.pi / 2, 1, 10)
plt.savefig("fractals.pdf", bbox_inches="tight")
