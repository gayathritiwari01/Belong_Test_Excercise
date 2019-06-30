package project.datatables;

import java.util.Locale;
import java.util.Map;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;
import io.cucumber.datatable.TableTransformer;
import project.dataobjects.Item;

public class Configurer implements TypeRegistryConfigurer {

	@Override
	public Locale locale() {
		return Locale.ENGLISH;
	}

	@Override
	public void configureTypeRegistry(TypeRegistry registry) {

		/*
		 * Maps DataTable with header row to multiple objects of Type<T>. Each row below
		 * the header is an object.
		 */
		registry.defineDataTableType(new DataTableType(Item.class, new TableEntryTransformer<Item>() {
			@Override
			public Item transform(Map<String, String> entry) {
				return Item.getInstance(entry);
			}
		}));

		/*
		 * Maps DataTable with label column to a single object of Type<T>. Left column
		 * is field name, right column is value.
		 */
		registry.defineDataTableType(new DataTableType(Item.class, new TableTransformer<Item>() {
			@Override
			public Item transform(DataTable table) throws Throwable {
				return Item.getInstance(table.asMaps().get(0));
			}
		}));

	}

}
