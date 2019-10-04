# Wicket reusables

Wicket 8.x reusables panels and behaviors for Bootstrap 4.x components

## Behaviors

__PopoverBehavior (based on popper.js)__

> PopoverBehavior relies on the 3rd party library Popper.js for positioning. __You must include popper.min.js before bootstrap.js__
    
```java
Button button = new Button("register");
button.add(new PopoverBehavior("Register user", "Please click to register user"); // Defaults [trigger: hover, placement: right]

Button button = new Button("register");
button.add(new PopoverBehavior("Register user", "Please click to register user", DataTrigger.CLICK, DataPlacement.BOTTOM));
```

## Panels

__Panel name...__

> Description...

```java
...
```


## 
#### Author

Linkedin: [https://www.linkedin.com/in/slawektuleja/](https://www.linkedin.com/in/slawektuleja/)

#### License

You can use this package freely in any project: free or commercial
