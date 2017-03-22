/**
 * Created by vince on 7/6/16.
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
    HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf("/tmp/Sathish_table_new"));

    tableDescriptor.addFamily(new HColumnDescriptor("cf1"));
    tableDescriptor.addFamily(new HColumnDescriptor("cf2"));

    admin.createTable(tableDescriptor);
    System.out.println("Table created");
  }
}
