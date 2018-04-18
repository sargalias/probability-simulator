package probabilitySimulator.program.information;

import probabilitySimulator.queries.Query;

public class SimpleInformation implements Information {
    Query query;

    public SimpleInformation(Query query) {
        this.query = query;
    }

    @Override
    public String information() {
        return query.getAllInfo();
    }
}
