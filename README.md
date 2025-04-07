# StrangerAtAFuneral

## Bugs

- image.getHeight()/getWidth() function in entity class used to resize sprite in draw methods seems to cause the shaking bug sometimes, using gp.tileSize helps
- if you start game, press a direction and while pressing direction press space it crashes (temp fix, null checker in Player.draw())
- If the writting is a block its due to rendering order (temp fix, change the order of rendering), like the UI.drawMessage() comes before UI.drawInventory()
- Use new Pixmap and texture instance for every thing in the optionTop() method in UI
- The pathfinder algorithm needs to be adjusted for libgdx, since the (0,0) is in the bottom left instead of the top left
- there a random path that colors other entities red also, but since its a debug path its not a big deal

- [ ] life goes below zero so it looks like consumables arent working sometimes
- [ ] dialogues are not initialized properly so if u dont speak to npc before a monster dialogue is trigger null pointer exception
- 
## Optomitizations

- Dont draw the cursor on every render in the inventory UI method
- Ui.OptionTop() texture is initialized on every render



