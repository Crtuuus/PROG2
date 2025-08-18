import numpy as np
from PIL import Image
import requests
from io import BytesIO

# Prenos in branje slike
url = "https://lovro.fri.uni-lj.si/pro2/exams/fmf.png"
img = Image.open(BytesIO(requests.get(url).content)).convert("L")
gray = np.asarray(img) / 255.0
h, w = gray.shape

# Priprava barvne slike
color_img = np.zeros((h, w, 3))
rgb_colors = {
    "cyan": np.array([0.0, 0.9, 0.9]),
    "yellow": np.array([0.9, 0.9, 0.0]),
    "magenta": np.array([0.9, 0.0, 0.9]),
    "gray": np.array([0.5, 0.5, 0.5]),
}

# Koordinate
i, j = np.meshgrid(np.arange(h), np.arange(w), indexing='ij')

# Maske
masks = {
    "cyan": ((j <= i) & (i < 624 - j)),
    "yellow": (i < np.minimum(j, 624 - j)),
    "magenta": ((624 - j <= i) & (i < j)),
    "gray": (i >= np.maximum(j, 624 - j)),
}

# Barvanje
for name, mask in masks.items():
    rgb = rgb_colors[name]
    for c in range(3):
        color_img[mask] = rgb * (1 - gray[mask])[..., None] + gray[mask][..., None] * np.array([1, 1, 1])
# Shranjevanje slike
Image.fromarray((color_img * 255).astype(np.uint8)).save("cym.png")
