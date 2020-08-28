let count=0;
let qt;
function setup() {
	createCanvas(400,400);

	let boundary =  new Rectangle(200,200,200,200);
	qt = new QuadTree(boundary , 4);

	console.log(qt);
	//
	for (let i = 0; i<300; i++) {
	  	let p = new Point(Math.random() *400 , Math.random()*400);
	  	qt.insert(p);
	}

}

function draw(){
	background(0);
	qt.show();
	
	stroke(0,255,0);
	rectMode(CENTER);
	let range=new Rectangle(mouseX,mouseY,50,50);
	rect(range.x,range.y,range.w*2,range.h*2);
	let points=[];
	qt.query(range,points);
	for(let p of points){
		strokeWeight(4);
		point(p.x,p.y);
	}
}
