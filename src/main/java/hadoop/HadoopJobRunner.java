package hadoop;

import java.io.IOException;

import hadoop.WordCount.Map;
import hadoop.WordCount.Reduce;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

public class HadoopJobRunner {
	
	public void runHadoopJOb(Class  jobClass, String name, String inpulFilePath,  String outpultFilePath) throws IOException{

		JobConf conf = new JobConf(jobClass);
		conf.setJobName(name);

		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(IntWritable.class);

		conf.setMapperClass(Map.class);
		conf.setCombinerClass(Reduce.class);
		conf.setReducerClass(Reduce.class);

		conf.setInputFormat(TextInputFormat.class);
		conf.setOutputFormat(TextOutputFormat.class);

		FileInputFormat.setInputPaths(conf, new Path(inpulFilePath));
		FileOutputFormat.setOutputPath(conf,new Path(outpultFilePath));
		JobClient.runJob(conf);
	
		
	}

}
