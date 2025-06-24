import random
import math
import matplotlib
import matplotlib.pyplot as plt


def priblizek_pi(n):
    v_krogu = 0
    vsi = 0
    for i in range(1, n):
        x = random.uniform(-1, 1)
        y = random.uniform(-1, 1)
        if (x**2 + y**2) < 1:
            v_krogu += 1
        vsi += 1
    return(4*v_krogu/vsi)

def main():
    # Različne velikosti vzorca (eksponentna rast)
    sample_sizes = [10**k for k in range(1, 7)]  # 10, 100, …, 1_000_000
    estimates    = [priblizek_pi(n) for n in sample_sizes]
    errors    = [abs(est - math.pi) for est in estimates]
    # Narišemo graf
    plt.figure(figsize=(8, 5))
    plt.plot(sample_sizes, estimates, marker='o', linestyle='-',
             label="Aproksimacija π")
    plt.axhline(math.pi, color='red', linestyle='--', label="π ≈ 3.1416")

    plt.xscale('log')  # log-os na horizontalni osi
    plt.xlabel("Število naključnih točk (log scale)")
    plt.ylabel("Aproksimacija π")
    plt.title("Monte Carlo aproksimacija π ob naraščajočem n")
    plt.legend()
    plt.grid(True, which="both", linestyle="--", alpha=0.4)

    # Shrani kot PNG in nato pokaži graf
    out_file = "pi_approximation.png"
    plt.savefig(out_file, dpi=300, bbox_inches='tight')
    print(f" Graf shranjen kot {out_file}")

    plt.show()  # odpre okno z grafom

    # Drugi plot: absolutna napaka vs n (log-log)
    plt.figure(figsize=(8, 5))
    plt.plot(sample_sizes, errors, marker='o', linestyle='-',
             label="Absolutna napaka")
    plt.xscale('log')
    plt.yscale('log')
    plt.xlabel("Število naključnih točk (log scale)")
    plt.ylabel("Absolutna napaka |π_est – π| (log scale)")
    plt.title("Napaka Monte Carlo aproksimacije π")
    plt.legend()
    plt.grid(True, which="both", linestyle="--", alpha=0.4)
    plt.show()  # odpre okno z grafom

if __name__ == "__main__":
    main()
