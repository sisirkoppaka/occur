# Occur
Scala implementation of Allen's Interval Logic


Basics
======

For reference, see http://www.ics.uci.edu/~alspaugh/cls/shr/allen.html

Only one of the 13 logical states can be true for any two given intervals. 

Any pair of intervals are described by exactly one of these states.

Build and run! The above property should hold for the two intervals considered. 

Uses
====

Consider a candidate appointment X and an already existing appointment Y for a user. (lb and ub are corresponding lower and upper boundaries of each appointment)

if X.before(Y)

	all is well, insert into calendar.

elif X.meets(Y)

	there is overlap from Y.lb to Y.ub==X.ub
	perform corresponding negotiation with user

elif X.overlaps(Y)

	ask user if Y can be moved by X.ub-Y.lb forward in time

elif X.starts(Y)

	there is overlap from X.lb==Y.lb to X.ub

elif X.during(Y)

	X occurs completely during Y

elif X.finishes(Y)

	there is overlap from X.lb to X.ub==Y.ub

elif X.equals(Y)

	complete overlap, X==Y

elif X.finishedBy(Y)

	there is overlap from Y.lb to X.ub==Y.ub

elif X.includes(Y)

	Y occurs completely during X

elif X.startedBy(Y)

	there is overlap from X.lb==Y.lb to Y.ub

elif X.overlappedBy(Y)

	ask user if Y can be preponed by Y.ub-X.lb (or vice versa postponement for X)

elif X.metBy(Y)

	X starts exactly aftr Y

elif X.after(Y)

	X starts after Y 

It is guaranteed that only one of the above blocks will execute. 

For multiple users, the pathway can have the inferred social hierarchy as weights.
