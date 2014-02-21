LZ77
====

Requirement : 

> JAVA 7


LZ77.JAVA - implementation of compression/decompression.


Following two classes implements the bit level operations needed

> BitInputStream.java  
> BitOutputStream.java



I have included one text file and one binary image file for testing.
Files generated will be stored in same directory as input file.

input-finename **-compressed**.extension - is the compressed file

input-finename **-decompressed**.extension - is the de-compressed file, which should be same as input file interms of size/bytes.

> java -jar LZ77.jar ./LZ77/example/textfile.txt
> java -jar LZ77.jar ./LZ77/example/imagefile.bmp
