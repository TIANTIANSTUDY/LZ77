LZ77
====

__Problem__ 

Almost-LZ77 compression

Given a description of the compressed data format, write code that compresses/decompresses files.


First, the compressed format:

> A 0 bit followed by eight bits means just copy the eight bits to the output directly.

> A 1 bit is followed by a pointer of 12 bits followed by a length encoded in 4 bits.  This is to be interpreted as "copy the <length> bytes from <pointer> bytes ago in the output to the current location".

For example:

"mahi mahi" can be compressed as: <0,'m'><0,'a'><0,'h'><0,'i'><0,' '><1,4,4>

Original size = 9 bytes, compressed = just under 8 bytes.

The compressor and decompressor should take binary files as input and output.  If you're familiar with Lempel-Ziv compressors, this is a simplified LZ77 compressor.



__Solution:__

Requirement : 

> JAVA 7


LZ77.JAVA - implementation of compression/decompression.


Following two classes implements bit streams to read/write individual bytes into file system.

> BitInputStream.java  
> BitOutputStream.java



I have included one text file and one binary image file for testing.
Files generated will be stored in same directory as input file.

input-finename **-compressed**.extension - is the compressed file

input-finename **-decompressed**.extension - is the de-compressed file, which should be same as input file interms of size/bytes.

> java -jar LZ77.jar ./LZ77/example/textfile.txt
> java -jar LZ77.jar ./LZ77/example/imagefile.bmp
