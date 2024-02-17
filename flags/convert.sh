#!/bin/bash

# Create the output directories if they don't exist
mkdir -p resized
# mkdir -p compressed

for file in *.{jpg,jpeg,png,gif,JPG,JPEG,PNG,GIF}; do
  # If the file does not exist, skip to the next iteration
  [ -e "$file" ] || continue

  # Get the base filename without the extension
  base=${file%%.*}

  # Trim the image and get its dimensions
  geometry=$(convert "$file" -fuzz 3% -trim +repage -format "%wx%h" info:)

  # Get the width and the height
  width=$(echo $geometry | cut -d 'x' -f 1)
  height=$(echo $geometry | cut -d 'x' -f 2)

  # Determine the max dimension
  max_dim=$(( width > height ? width : height ))

  # Pad the image to a square with transparency
  convert "$file" -fuzz 3% -trim +repage -background none -gravity center -extent ${max_dim}x${max_dim} "resized/${base}.png"
  convert "$file" -fuzz 3% -trim +repage -resize 200x200 -background none -gravity center -extent 200x200 "resized/${base}_sm.png"

  # Use cwebp to compress the image and store in the 'compressed' directory
  # cwebp -lossless -exact -z 9 -mt "resized/${base}.png" -o "compressed/${base}.webp"
  # cwebp -lossless -exact -z 9 -mt "resized/${base}_sm.png" -o "compressed/${base}_sm.webp"
done
