/**
 * Test Code to Create Sample MapR DB in mentioned path
 *
 */

import java.io.IOException;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.TableName;

import org.apache.hadoop.conf.Configuration;

public class CreateTable {

  public static void main(String[] args) throws IOException {
    Configuration configuration = HBaseConfiguration.create();
    HBaseAdmin admin = new HBaseAdmin(configuration);
    HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf("/tmp/Sathish_table_new"));	// To user different cluster use: maprfs://<clustername>/<path here>
    //Example: maprfs://mynewcluster/tmp/createtable, If you dont mention any clsuter name here, By default it uses the current cluster where you run the code
    
    tableDescriptor.addFamily(new HColumnDescriptor("cf1"));
    tableDescriptor.addFamily(new HColumnDescriptor("cf2"));

    admin.createTable(tableDescriptor);
    System.out.println("Table created");
  }
}
