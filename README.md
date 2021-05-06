# Music Visualiser Project

Name: Diogo Cardoso Lessa Carmo Reis

Student Number: C19768619

# Description of the assignment

A starfield that moves according to the frequency of the song playing. It has 3 different "modes" the first one, which is the main one, a basic rainbow-colored field of stars that moves faster according to the song. The second one is a sort of hyperspace mode and the third and final one is a mix between the first one and a planetoid that has 3 different orbits of spheres around it, this planetoid grows bigger with the frequency of the song and the orbits increase their speed of rotation around the planetoid as well. All of these modes have an interactive perspective that the user can change based on the position of the mouse and the user can also choose from a selection of 4 songs chosen beforehand by me.

# Instructions

The user can switch between the different modes by pressing the following buttons:

- 0 = main mode (basic rainbow starfield)
- 1 = hyperspace
- 2 = planetoid
- q = Party like it's 1923 by Teminite
- w = After Dawn by Jaeger and Meric
- e = Waterfront by Detrace( which is by far my favorite)
- r = return to the first song (aka Inception by Teminite)
- space bar = pausing the song
- enter = restarting the song

As stated above moving the mouse will change the perspective of the user.

# How it works

Starfield.java is the class that runs everything in the background, it's responsible for the keyboard inputs, the settings, the music so on and so forth. Inside of starfield.java, star.java and planet.java are called in a switch case. star[i].show is used to create the stars whilst star[i].update is used to update the position of the stars, so that the user has the feeling that the stars get bigger the closer they are to the user.
The planet class is used to create the planetoid and its different orbit of spheres. 
It is also in charge of their rotation.

- starfield
![An image](images/star.png)

- hyperspace
![An image](images/hyper.png)

- planetoid
![An image](images/planet.png)

# What I am most proud of in the assignment

I'll bed was when i discovered hy very honest the thing that makes me the most prouperspace mode by mistake when I accidentaly took the pz = z, which resets the position of pz to its original state.I decided to keep since it reminded me of how hyperspace would be implemented in "old movies"( for me at least).

# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

