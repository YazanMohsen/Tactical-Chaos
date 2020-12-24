package Champions;

import java.util.List;

public  class StoreFilter {

    protected StoreFilter decoratedSotreFilter;
    private InGameStore Store;

    protected StoreFilter(StoreFilter SotreFilter)
{
decoratedSotreFilter=SotreFilter;
}
public StoreFilter()
{
    Store=InGameStore.getObject();

} 

public List<Champion> getChampionList()
{

return Store.getChampions();

}



    public void print()
    {
    Store.print();
    }

}
