import math
import random
import matplotlib.pyplot as plt

def monte_pi(n):
    v_krogu = 0
    pi_values = []
    errors = []
    steps = []
    for i in range(1, n + 1):
        x, y = random.uniform(-1, 1), random.uniform(-1, 1)
        if x**2 + y**2 <= 1:
            v_krogu += 1
        if  i%100==0 or i < 100:
            pi_approx = 4 * v_krogu / i
            pi_values.append(pi_approx)
            errors.append(abs(pi_approx - math.pi))
            steps.append(i)
    return steps, pi_values, errors

# Izvedi simulacijo (do n=100000)
n = 10000000
x_vals, y_pi, y_err = monte_pi(n)

# Nariši grafa
fig, axs = plt.subplots(1, 2, figsize=(30, 6))

axs[0].plot(x_vals, y_pi)
axs[0].set_xscale("log")
axs[0].set_title("Aproksimacija števila π")
axs[0].set_xlabel("Število točk n")
axs[0].set_ylabel("Približek π")

axs[1].plot(x_vals, y_err)
axs[1].set_xscale("log")
axs[1].set_yscale("log")
axs[1].set_title("Absolutna napaka π")
axs[1].set_xlabel("Število točk n")
axs[1].set_ylabel("|π - približek|")

plt.tight_layout()
plt.savefig("pi.pdf")
