# StrangerAtAFuneral

## Bugs

- image.getHeight()/getWidth() function in entity class used to resize sprite in draw methods seems to cause the shaking bug sometimes, using gp.tileSize helps
- if you start game, press a direction and while pressing direction press space it crashes (temp fix, null checker in Player.draw())
- If the writting is a block its due to rendering order (temp fix, change the order of rendering), like the UI.drawMessage() comes before UI.drawInventory()


## Optomitizations

- Dont draw the cursor on every render in the inventory UI method



