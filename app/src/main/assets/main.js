
var currentFormat ='';



function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

function getRandomColor(){

var colorNumber = getRandomInt(1,10);
var currentColor = 'red'
switch (colorNumber){
	case 1:
		currentColor='red';
		break;
	case 2:
		currentColor = 'blue';
		break;
	case 3:	
		currentColor = 'yellow';
		break;
	case 4:
		currentColor = 'pink';
		break;
	case 5:
		currentColor = 'orange';
		break;
	case 6:	
		currentColor = 'green';
		break;
	case 7:
		currentColor= 'purple';
		break;
	case 8:
		currentColor = 'brown';
		break;
	case 9:
		currentColor = 'navy';
		break;
	case 10:
		currentColor = 'gold';
		break;
	default:
		break;
		
}

return currentColor;


}

function getRandomShape(){

var shapeNumber = getRandomInt(1,5);
var squareText = 'A square has four equal sides.  All squares are rectangles but not all rectangles are squares.  A square can also mean a public area, or a city block, or an old-fashioned person.  Square can also be used as a verb meaning to check for right angles or to even the score.  Some things you might see in everday life that are square are keyboard keys, checkerboard squares, some kinds of crackers, such as Cheez-its or Triscuits, and handkercheifs.'
var rectangleText = 'A rectangle is a form of parallelogram having four right angles.  All squares are rectangles but not all rectangles are squares.  We see many examples of rectangles in every day life such as computer screens, most picture frames, many road signs, and windows.  The word rectangle might come from the Medical Latin rectangulum.'
var circleText = 'A circle is a closed curve with all points being equidistant from the center point of such curve.  A circle can also be used to describe a theater section, an area in which something operates or has influence, and as a verb might mean to enclose, surround, or to avoid collision with.  A famous idiom using circle is Circle the Wagons!'
var ovalText = 'An oval has the general form of an egg, and is elliptical or ellipsoidal.  Oval, oval, shining bright, you are nearly a circle, but not quite.'
var parallelogramText = 'A parallelogram is a four sided figure having both pairs of opposite sides parallel to each other.  Parallell means extending in the same direction, equally distant at all points, and never converging.'

var currentShape = 'square'
var shapeText = squareText;
switch (shapeNumber){
	case 1:
		currentShape='square';
		shapeText = squareText;
		break;
	case 2:
		currentShape = 'rectangle';
		shapeText = rectangleText;
		break;
	case 3:	
		currentShape = 'circle';
		shapeText = circleText;
		break;
	case 4:
		currentShape = 'oval';
		shapeText = ovalText;
		break;
	case 5:
		currentShape  = 'parallelogram';
		shapeText = parallelogramText;
		break;
	default:
		break;
		
}

return [currentShape,shapeText];


}



function addRandomElement(){



	var eightFour = '<div class="row" id="eight_four"><div class="col-sm-8 col-xs-8" id="eight_four_text">%shape_text%</div><div class="col-sm-4 col-xs-4"><div class="shape_image %shape% %color%"></div></div></div>'
	var fourEight = '<div class="row" id="four_eight"><div class="col-sm-4 col-xs-4"><div class="shape_image %shape% %color%"></div></div><div class="col-sm-8 col-xs-8" id="four_eight_text">%shape_text%</div></div>'
	var fourFour = '<div class="row" id="four_four"><div class="col-sm-4 col-xs-4" id="four_four_one">44</div><div class="col-sm-4 col-xs-4" id="four_four_two"></div><div class="col-sm-4 col-xs-4" id="four_four_three"></div></div>'


// determine which row format to use
var rowFormat = getRandomInt(1,2);


currentFormat = eightFour;

switch(rowFormat){

	case 1:
		break;
	case 2:
		currentFormat = fourEight;
		break;
	case 3:
		currentFormat = fourFour;
		break;
	default:
		break;

}

var shapeArray = getRandomShape();
newCurrentFormat = (currentFormat.replace('%shape_text%',shapeArray[1])).replace('%color%',getRandomColor());
$(".container").append(newCurrentFormat.replace("%shape%",shapeArray[0]));



}

function initializePage(){
for (i=0;i<13;i++){

addRandomElement();

}

}

window.addEventListener('load',initializePage);

$('document').ready(function(){  
   
    scrollalert();  
}); 
  
function scrollalert(){  
    var scrolltop=$('#scrollbox').attr('scrollTop');  
    var scrollheight=$('#scrollbox').attr('scrollHeight');  
    var windowheight=$('#scrollbox').attr('clientHeight');  
    var scrolloffset=20;  
    if(scrolltop>=(scrollheight-(windowheight+scrolloffset)))  
    {  
        for(i=0;i<10;i++){
		addRandomElement();
		}
    }  
    setTimeout('scrollalert();', 1500);  
}  
